#!/usr/local/bin/bb
;;
;; Assuming you have a file with braze_id values (one per line)...
;;
;;   usage: cat <file> | delete-braze-users.bb APIKEY
;;
;; capture the output and execute the curl commands.
;;
;; CAREFUL with that APIKEY:
;;  - the key itself is all that identifies the app group.
;;  - Use the wrong key? you might be deleting production data!!!
;;

(require '[clojure.java.io :as io])
(require '[clojure.string :as string])

(let
  [
   base-url "https://rest.iad-02.braze.com"
   endpoint "/users/delete"
   api-key (first *command-line-args*)
   batch-size 50 ; process as many records as the api can handle
   ]

  (when-not api-key
    (println "Must provide api-key as cli arg.")
    (System/exit 1))

  (with-open [reader (io/reader *in*)]
    (doseq
      [braze-ids (partition-all batch-size (line-seq reader))]
      (println
        (str
          "curl --location --request POST '" base-url endpoint "'"
          " --header 'Content-Type: application/json'"
          " --header 'Authorization: Bearer " api-key "'"
          " --data-raw '{ \"braze_ids\": ["
          (string/join "," (map #(str " " \" % \") braze-ids))
          " ]"
          " }'"
          )
        )
      )
    )
  )
