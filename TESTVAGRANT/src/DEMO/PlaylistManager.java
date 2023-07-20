package DEMO;
import java.util.HashMap;

class Node {
    String song;
    String user;
    Node prev;
    Node next;

    public Node(String song, String user) {
        this.song = song;
        this.user = user;
    }
}
class DoublyLinkedList {
	
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addToFront(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void moveToFront(Node node) {
        if (node == head) {
            return;
        }

        if (node == tail) {
            tail = node.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }

    public void removeTail() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            size--;
        }
    }

    public int getSize() {
        return size;
    }
}

public class PlaylistManager {

	int capacity;
	HashMap<String, DoublyLinkedList> playlists;

	public PlaylistManager(int capacity) {
		this.capacity = capacity;
		this.playlists = new HashMap<>();
	}

	public void addSong(String user, String song) {
		if (!playlists.containsKey(user)) {
			playlists.put(user, new DoublyLinkedList());
		} else {
			DoublyLinkedList playlist = playlists.get(user);
			Node newNode = new Node(song, user);
			playlist.addToFront(newNode);
			if (playlist.getSize() > capacity) {
				playlist.removeTail();
			}
		}
	}

	public void printPlaylist(String user) {
		if (playlists.containsKey(user)) {
			DoublyLinkedList playlist = playlists.get(user);
			Node current = playlist.head;
			while (current != null) {
				System.out.print(current.song + " ");
				current = current.next;
			}
			System.out.println();
		} else {
			System.out.println("User not found.");
		}
	}
}