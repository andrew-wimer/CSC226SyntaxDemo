;;ANDREW WIMER
;;CSC 226 APRIL 2020
;;PROJECT 3 PROGRAM 2: DEMONSTRATING SYNTAX

;;to start: comments begin after  a semicolon (;)

(comment here is a block comment)

;; projc3demo2.core is our namespace, defined with the ns function.
;;Parentheses in Clojure are primarily used to scope functions and the functions performed within those
;;functions. Parentheses must always balance out! Most IDEs will display where matched parentheses are or
;;where missing parentheses are not.
(ns proj3demo2.core
  (:gen-class))
(require '[clojure.edn :as edn])
;;our project requires the clojure.edn library as an external dependency


;;Global variables will be defined with the def function. def will declare a variable to be global no matter
;how deep a def function is within a nest of other functions.
;;Here is an integer, a 64-bit long type.
(def anInteger 10)
;Here is a float point, double-precision and 64-bits.
(def aFloat 0.82)
;Here is a ratio, consisting of a numerator and a denominator. It allows for representing exact values instead
;of floating point estimated values for rational numbers.
(def aRatio 13/5)

;;All functions will be defined using the function defn.
;;defn is followed by the function name, and all functions must have a [ ] for args.
;a blank space between denotes no arguments. Otherwise, each argument is separated by whitespace.
(defn multiInput [a b c]
  (println "a = " a)                                        ;;output in a println function is not contained within
  ;;braces, brackets, or parens. There is no need for a connector like . or +, either: only whitespace needed.
  ;;double quotes "" begin and end string literals.

  (def d 10)

  (println "now d = " d)                                    ;;d will = 10 here

  (let [d (+ b 1)]                                          ;;(+ b 1) equivalent to (b + 1)
    ;;note the format: between the parentheses, on the left is our function + and to its right are the arguments
    ;;b and 1

    (println "d = " d))                                     ;;d will = (b + 1) here, depending on b

  (println "now d = " d)                                    ;;outside of the let scope, d = 10 again.

  (println "b = " b)

  (- c 2)                                                   ;;equivalent to (c - 2)

  (println "c = " c))

;function: ;hello
;;this function will output different greetings depending upon arguments received.
;; this is a multi-arity function. Each argument with a unique set of parameters
;; can be a unique arity.
(defn hello
  ([] (println "Hello there, stranger."))
   ([name] (println "Pleasure to be more acquainted, " name)))

;;The main function will usually be at the bottom of our namespace.
(defn -main
  [& args]

  (hello)                                                   ;;function call
  (println "You don't have to be a stranger, though. Your name? ") ;;function call with arguments

  (def yourName (read-line))
  ;;again, variables as accompanied "def" in the parens above, are global no matter
  ;;what scope they are declared within.
  ;;the read-line function is an argument to the yourName variable.
  ;;So yourName will be defined by user input.


  (hello yourName)                                          ;;function call with arguments

  (println '("red" "blue" "yellow"))                        ;;print a list literal, established with '()
  (println ["sparrow" "crow" "owl"])                        ;;print a vector literal, established with []
  (print {:oak "leaf", :pine "needle", :maple "leaf"} " ")          ;;print a map literal, established with {}
  ;;and with pairs of keys + values, each pair separated by white space (commas, new lines, blank spaces).
  ;keys are prefixed with a colon (:)
  ;;print also works the same as println function, minus the new line
  (println #{1 10 100 1000 10000})                        ;;print a set literal, established with []

  (println \p)                                              ;;print character literal p, with prefix \

  ;;all of these println functions will return nil if this program is executed. nil is "null"

  (multiInput 2 3 5)                                        ;;function with multiple arguments separated
  ;;by whitespace

  (println "good bye!")
  )

;;sample output of main function:
(comment (-main)
         Hello there, stranger.
         You don't have to be a stranger, though. Your name?
         Andrew
         Pleasure to be more acquainted,  Andrew
         (red blue yellow)
         [sparrow crow owl]
         {:oak leaf, :pine needle, :maple leaf} #{1 10000 1000 100 10}
         p
         a =  2
         now d =  10
         d =  4
         now d =  10
         b =  3
         c =  5
         good bye!
         => nil)
;;end of namespace