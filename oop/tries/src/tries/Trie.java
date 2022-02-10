package tries;

import java.util.Set;

public class Trie {
    public Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child); 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    
    public boolean isPrefixValid(String prefix) {
    	Node currentNode = this.root;
    	for(int i = 0; i < prefix.length(); i++) {
    		Character currentCharacter = prefix.charAt(i);
    		if(!currentNode.children.containsKey(currentCharacter)) {
    			return false;
    		} else {
    			currentNode = currentNode.children.get(currentCharacter);
    		}
    	}
    	return true;    		
    }

    public boolean isWordValid(String word) {
    	Node currentNode = this.root;
    	for(int i = 0; i < word.length(); i++) {
    		Character currentCharacter = word.charAt(i);
    		if(!currentNode.children.containsKey(currentCharacter)) {
    			return false;
    		} else {
    			currentNode = currentNode.children.get(currentCharacter);
    		}
    	}
    	if(currentNode.isCompleteWord) {
    		return true;    		
    	} else {
    		return false;
    	}
    }
    
    public void printAllKeys(Node node) {
    	Set<Character> keys = node.children.keySet();
    	for(Character key : keys) {
    		System.out.println(key);
    		this.printAllKeys(node.children.get(key));
    	}
    }
}
