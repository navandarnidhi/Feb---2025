import java.time.LocalDate;
import java.util.*;

class Participant {
    int participantId;
    String participantName;
    int age;
    String email;
    String phone;

    public Participant(int participantId, String participantName, int age, String email, String phone) {
        this.participantId = participantId;
        this.participantName = participantName;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ID: " + participantId + ", Name: " + participantName + ", Age: " + age + ", Email: " + email + ", Phone: " + phone;
    }
}

class Event implements Comparable<Event> {
    int eventId;
    String eventName;
    LocalDate eventDate;
    String eventType;
    List<Participant> participantsList;

    public Event(int eventId, String eventName, LocalDate eventDate, String eventType) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.participantsList = new ArrayList<>();
    }

    public void addParticipant(Participant p) {
        participantsList.add(p);
    }

    public void removeParticipant(int participantId) {
        participantsList.removeIf(p -> p.participantId == participantId);
    }

    @Override
    public int compareTo(Event other) {
        return this.eventDate.compareTo(other.eventDate);
    }

    @Override
    public String toString() {
        return "Event ID: " + eventId + ", Name: " + eventName + ", Date: " + eventDate + ", Type: " + eventType;
    }
}

public class EventManagementSystem {
    Map<Integer, Event> events = new HashMap<>();
    Set<Event> eventSet = new TreeSet<>();

    public void addEvent(Event event) {
        events.put(event.eventId, event);
        eventSet.add(event);
    }

    public Event searchEventByName(String name) {
        return events.values().stream().filter(e -> e.eventName.equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public void displayEventsSortedByDate() {
        eventSet.forEach(System.out::println);
    }

    public void listParticipantsInEvent(int eventId) {
        Event event = events.get(eventId);
        if (event != null) {
            event.participantsList.forEach(System.out::println);
        } else {
            System.out.println("Event not found");
        }
    }

    public void removeParticipantFromEvent(int eventId, int participantId) {
        Event event = events.get(eventId);
        if (event != null) {
            event.removeParticipant(participantId);
        }
    }

    public void displayEventsForParticipant(int participantId) {
        events.values().stream()
                .filter(e -> e.participantsList.stream().anyMatch(p -> p.participantId == participantId))
                .forEach(System.out::println);
    }

    public void filterEventsByType(String type) {
        events.values().stream().filter(e -> e.eventType.equalsIgnoreCase(type)).forEach(System.out::println);
    }

    public static void main(String[] args) {
        EventManagementSystem system = new EventManagementSystem();
        Event e1 = new Event(1, "Tech Conference", LocalDate.of(2025, 4, 10), "Conference");
        Event e2 = new Event(2, "Music Fest", LocalDate.of(2025, 6, 15), "Concert");
        system.addEvent(e1);
        system.addEvent(e2);

        Participant p1 = new Participant(101, "Alice", 25, "alice@example.com", "1234567890");
        Participant p2 = new Participant(102, "Bob", 30, "bob@example.com", "9876543210");
        e1.addParticipant(p1);
        e2.addParticipant(p2);

        System.out.println("All Events Sorted by Date:");
        system.displayEventsSortedByDate();
    }
}
