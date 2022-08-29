(jde-project-file-version "1.0")

(jde-set-variables
 '(jde-sourcepath (quote (
                          ;; Source directories...
                          "src"

                          ;; Source for supporting packages...
                          "/app/log4j-1.2.12/src/java"
                          "/app/jdom-1.0/src/java"

                          ;; ...and the jdk itself...
                          "/app/jdk-1.4.2/src"
                          )
                         )
                  )
 '(jde-global-classpath (quote (
				"./src"
				"./classes"
				"./lib"
				"./images"
				)
			       )
			)
 '(jde-compile-option-directory "./classes")
 '(jde-compile-option-deprecation t)
 '(jde-run-working-directory ".")
 )
