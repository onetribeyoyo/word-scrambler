# word-scrambler

## Original Text ##
    According to research at an English university, it doesn't matter in what order
    the letters in a word are, the only important thing is that the first and last
    letter is at the right place.  The rest can be a total mess and you can still read
    it without problem.  This is because we do not read every letter by itself but the
    word as a whole.

## Scrambled Text ##

    Aoccdrnig to rsceearh at an Elingsh uinervtisy, it deosn't mttaer in waht oredr
    the ltteers in a wrod are, the olny iprmoatnt tihng is taht the frist and lsat
    ltteer is at the rghit pclae. The rset can be a toatl mses and you can sitll raed
    it wouthit porbelm. Tihs is bcuseae we do not raed ervey lteter by it slef but the
    wrod as a wlohe.

- leading and trailing punctuation is left in place
- trailing digits are left in place
- internal punctuation (like the apostrophe in don't) is striped out of the scrambled result
- the scrambled part of each word is downcased, unless the entire word was capitalized to begin with,
  in which case the case is preserved


## Usage Example ##

    groovy Scrambler.groovy <text to you would like to scramble>

results in

    txet to you wloud lkie to scbmalre

## Origins: ##

- <http://www.mrc-cbu.cam.ac.uk/people/matt.davis/Cmabrigde/>
- Rawlinson, G. E. (1976) The significance of letter position in word recognition. Unpublished PhD Thesis, Psychology Department, University of Nottingham, Nottingham UK.
- Original demonstration of the effect of letter randomisation by Graham Rawlinson's 1999 letter to New Scientist.
  <http://archive.newscientist.com/secure/article/article.jsp?rp=1&id=mg16221887.600>
  <http://www.mrc-cbu.cam.ac.uk/people/matt.davis/Cmabrigde/newscientist_letter.html>
