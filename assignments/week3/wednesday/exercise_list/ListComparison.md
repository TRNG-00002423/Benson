LinkedList is better if you want o(1) head pop as all you do is update the head ptr. Something like a queue benefits from this. Accessing a random element will be o(n).

ArrayList is better if you need to access random elements. However popping the head is o(n) as you need to shift and update all the indices.