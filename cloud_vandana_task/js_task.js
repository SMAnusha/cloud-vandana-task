function reverseWords(sentence) {
  const words = sentence.split(" ");
  const reversedWords = words.map(function(word) {
    return word.split("").reverse().join("");
  });
  return reversedWords.join(" ");
}

function compareNumbers(a, b) {
  return b - a;
}

const sentence = "This is a sunny day";
const reversedSentence = reverseWords(sentence);
console.log(reversedSentence);

const numbers = [5, 2, 8, 1, 9, 3];
numbers.sort(compareNumbers);
console.log(numbers);

