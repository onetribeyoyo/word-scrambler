/**
 *  <p>According to research at an English university, it doesn't matter in what order the letters
 *  in a word are, the only important thing is that the first and last letter is at the right place.
 *  The rest can be a total mess and you can still read it without problem.  This is because we do
 *  not read every letter by itself but the word as a whole.
 *
 *  <h4>Scrambled:</h4>
 *
 *  <p>Aoccdrnig to rsceearh at an Elingsh uinervtisy, it deosn't mttaer in waht oredr the ltteers
 *  in a wrod are, the olny iprmoatnt tihng is taht the frist and lsat ltteer is at the rghit
 *  pclae. The rset can be a toatl mses and you can sitll raed it wouthit porbelm. Tihs is bcuseae
 *  we do not raed ervey lteter by it slef but the wrod as a wlohe.
 *
 *  <h4>Notes:</h4>
 *
 *  <ul>
 *    <li> leading and trailing punctuation is left in place
 *    <li> trailing digits are left in place
 *    <li> internal punctuation (like the apostrophy in don't) is striped out of the scrambled result
 *    <li> the scrambled part of each word is downcased, unless the entire word was capitalized to
 *         begin with, in which case the case is preserved
 *  </ul>
 *
 *  <h4>Origins:</h4>
 *
 *  <ul>
 *    <li> http://www.mrc-cbu.cam.ac.uk/people/matt.davis/Cmabrigde/
 *
 *    <li> Rawlinson, G. E. (1976) The significance of letter position in word recognition. Unpublished PhD
 *         Thesis, Psychology Department, University of Nottingham, Nottingham UK.
 *
 *    <li> Original demonstration of the effect of letter randomisation by Graham Rawlinson's 1999 letter to
 *         New Scientist.
 *         http://archive.newscientist.com/secure/article/article.jsp?rp=1&id=mg16221887.600
 *         http://www.mrc-cbu.cam.ac.uk/people/matt.davis/Cmabrigde/newscientist_letter.html
 *  </ul>
 *
 *  Run with `groovy Scrambler.groovy <txet to you wloud lkie to scbmalre>`
 */
class Scrambler {

    static void main(String[] args) {

        // scramble each word...
        Scrambler scrambler = new Scrambler()
        args.each { word ->
            print scrambler.scramble(word)
            print " "
        }
        println ""
    }

    /**
     *  Surrounding punctuation is not scrambled when it truly surrounds a word:
     *      (what?) --> (waht?)
     *  and it is stripped out and ignored when contained within a word:
     *      gobbled(y)gook --> gloybbdoogok
     */
    String[] SURROUNDING_PUNCTUATION = [
        "`", // left single quote
        "'", // single quote
        "(", // left paren
        ")", // right paren
        "<", // less than sign
        ">", // greater than sign
        "[", // left bracket
        "]", // right bracket
        "{", // left curly brace
        "}", // right curly brace
    ]

    /**
     *  Left in place when it comes at the end of a word
     */
    String[] TERMINAL_PUNCTUATION = [
        "!", // exclamation mark
        ".", // period
        ":", // colon
        ";", // semicolon
        "?",  // question mark
    ]

    /**
     *  Transient punctuation will be removed from within words unless the word without punctuation is all
     *  numeric.  This list includes punctiation commonly found on a US-english keyboard.
     */
    String[] TRANSIENT_PUNCTUATION = SURROUNDING_PUNCTUATION + TERMINAL_PUNCTUATION + [
        "#", // pound sign
        "\$", // dollar sign
        "%", // present sign
        "&", // ampersand
        "*", // asterisk
        "+", // plus sign
        ",", // comma
        "-", // dash
        "/", // slash
        "=", // equals sign
        "@", // at sign
        "\"", // double quote
        "\\", // backslash
        "^", // carat
        "_", // underscore
        "~", // tilde
    ]

    String scramble(String word) {

        StringBuilder builder = new StringBuilder()

        //println "    word --> ${word}"
        int wordLength = word.length()

        // Trim leading and trailing punctuation off of the word.
        // Also trim off leading and trailing digits.
        String leadingPunctuation = ""

        int firstPosition = 0
        for (int i = 0; (i < (wordLength - 1)) && (! Character.isLetter(word.charAt(i))); i++) {
            leadingPunctuation += word.substring(i, i+1)
            firstPosition++
            //println "    leadingPunctuation --> ${leadingPunctuation}"
        }
        // put the leading punctuation into the result right away
        builder.append(leadingPunctuation)

        String trailingPunctuation = ""
        int lastPosition = wordLength - 1
        for (int i = lastPosition; (i >= firstPosition) && (! Character.isLetter(word.charAt(i))); i--) {
            trailingPunctuation = word.substring(i, i+1) + trailingPunctuation
            lastPosition--
        }
        //println "    trailingPunctuation --> ${trailingPunctuation}"

        // trim the word down to the part that will be scrambled...
        word = word.substring(firstPosition, lastPosition+1)
        wo<rdLength = word.length()
        //println "    trimmed --> ${word)}"


        // figure out if this is an allcaps word
        boolean allCaps = true
        for (int i = 0; i < wordLength; i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                allCaps = false
                break
            }
        }

        switch (wordLength) {
        case 0: // zero length words occur when punctuation stands by itself (like ".").
        case 1: // like "a" or "I".
        case 2: // like "to" or "or".
        case 3: // like "and" or "the"
            {
                // special case for short words....
                builder.append(word)
                break
            }
        case 4: // like "this" or "that"
            {
                // special case for four letter words: always swap the second and third characters.
                // I know it's not random, but I like the results.
                builder.append(word.substring(0, 1))
                if (allCaps) {
                    builder.append(word.substring(2, 3))
                    builder.append(word.substring(1, 2))
                }
                else {
                    builder.append(word.substring(2, 3).toLowerCase())
                    builder.append(word.substring(1, 2).toLowerCase())
                }
                builder.append(word.substring(3, 4))
                break
            }
        default:
            {
                // Note: down-casing everything but the first character.
                // Note: removing all terminal punctuation.

                // TODO: ignore leading quotes?

                String firstChar = word.substring(0, 1)
                String lastChar = word.substring(wordLength - 1)

                // randomly scramble the middle characters
                String middlePart = word.substring(1, wordLength - 1)
                int middlePartLength = wordLength - 2
                java.util.List<String> middlePartAsList = new ArrayList<String>()
                for (int i = 0; i < middlePartLength; i++) {
                    String character = middlePart.substring(i, (i + 1))
                    if ( !(character in TRANSIENT_PUNCTUATION) ) {
                        middlePartAsList.add(character)
                    } else {
                        // skip the punctuation characters
                    }
                }
                Collections.shuffle(middlePartAsList)

                // put the word back together
                builder.append(firstChar)
                //builder.append("---")
                for (String character : middlePartAsList) {
                    if (allCaps) {
                        builder.append(character)
                    }
                    else {
                        builder.append(character.toLowerCase())
                    }
                }
                builder.append(lastChar)
            }
        }

        // add back trailingPunctuation
        builder.append(trailingPunctuation)

        return builder.toString()
    }

}
