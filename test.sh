echo
echo "~ short words --------------------------------------------------------------------------------"
groovy Scrambler.groovy i
groovy Scrambler.groovy am
groovy Scrambler.groovy god
groovy Scrambler.groovy word

echo
echo "~ with trailing punctuation ------------------------------------------------------------------"
groovy Scrambler.groovy .
groovy Scrambler.groovy i.
groovy Scrambler.groovy am.
groovy Scrambler.groovy god.
groovy Scrambler.groovy word.

echo
echo "~ with surrounding punctuation ---------------------------------------------------------------"
groovy Scrambler.groovy \".\"
groovy Scrambler.groovy \"i.\"
groovy Scrambler.groovy \"am.\"
groovy Scrambler.groovy \"god.\"
groovy Scrambler.groovy \"word.\"

echo
echo "~ with internal punctuation ------------------------------------------------------------------"
groovy Scrambler.groovy \"wo\'\(r\)d.\"

echo
echo "~ longer words -------------------------------------------------------------------------------"
groovy Scrambler.groovy longer
groovy Scrambler.groovy longer
groovy Scrambler.groovy longer
groovy Scrambler.groovy longer
groovy Scrambler.groovy longer
groovy Scrambler.groovy longer
groovy Scrambler.groovy longer
groovy Scrambler.groovy longer
groovy Scrambler.groovy longer

echo
echo "~ upper/lower case ---------------------------------------------------------------------------"
groovy Scrambler.groovy hudson
groovy Scrambler.groovy Hudson
groovy Scrambler.groovy HUDSON

echo
echo "~ with digits --------------------------------------------------------------------------------"
groovy Scrambler.groovy hudson32700
groovy Scrambler.groovy Hudson32700
groovy Scrambler.groovy HUDSON32700

echo
echo "~ all together now ---------------------------------------------------------------------------"
groovy Scrambler.groovy MAmiller7-90080
groovy Scrambler.groovy 627-9008

echo
echo "~ a long sentence ----------------------------------------------------------------------------"
groovy Scrambler.groovy \
According to research at an English university, it doesn\'t matter in what order the letters in a word are, the only important thing is \
that the first and last letter is at the right place.  The rest can be a total mess and you can still read it without problem.  This is \
because we do not read every letter by itself but the word as a whole.
echo "~ and again ----------------------------------------------------------------------------------"
groovy Scrambler.groovy \
According to research at an English university, it doesn\'t matter in what order the letters in a word are, the only important thing is \
that the first and last letter is at the right place.  The rest can be a total mess and you can still read it without problem.  This is \
because we do not read every letter by itself but the word as a whole.

echo
echo "~ --------------------------------------------------------------------------------------------"
