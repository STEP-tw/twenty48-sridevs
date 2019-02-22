(ns twenty48.core
  (:gen-class))

(def not-zero? (comp not zero?))

(def shift-left-zeroes (partial sort-by not-zero?))

(def split-identical (partial partition-by identity))

(def pair-up (comp reverse (partial partition-all 2)))

(def groupify (partial mapcat pair-up))

(def ordered-pairs (comp groupify split-identical shift-left-zeroes))

(def sum (partial reduce +))

(def sum-up (partial map sum))

(def prepend-zeroes (partial concat `(0 0 0 0)))

(def take-last-4 (partial take-last 4))

(def move-row-right (comp take-last-4 prepend-zeroes sum-up ordered-pairs))

(def move-row-left (comp reverse move-row-right reverse))

(def move-grid-right (partial map move-row-right))

(def move-grid-left (partial map move-row-left))

(def map-through (partial map list))

(def tilt (partial apply map-through))

(def move-grid-down (comp tilt move-grid-right tilt))

(def move-grid-up (comp tilt move-grid-left tilt))
