import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Participant {
    private int participantId;
    private String participantName;
    private int age;
    private String email;
    private String phone;

    public Participant(int participantId, String participantName, int age, String email, String phone) {
        this.participantId = participantId;
        this.participantName = participantName;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public int getParticipantId() {
        return participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    @Override
    public String toString() {
        return "ID: " + participantId + ", Name: " + participantName + ", Age: " + age +
               ", Email: " + email + ", Phone: " + phone;
    }
}

class Event {
    private int eventId;
    private String eventName;
    private LocalDate eventDate;
    private String eventType;
    private List<Participant> participantsList;

    public Event(int eventId, String eventName, LocalDate eventDate, String eventType) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.participantsList = new ArrayList<>();
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public String getEventType() {
        return eventType;
    }

    public List<Participant> getParticipantsList() {
        return participantsList;
    }

    public void addParticipant(Participant participant) {
        participantsList.add(participant);
    }

    public void removeParticipant(int participantId) {
        participantsList.removeIf(p -> p.getParticipantId() == participantId);
    }

    @Override
    public String toString() {
        return "Event ID: " + eventId + ", Name: " + eventName + ", Date: " + eventDate + ", Type: " + eventType;
    }
}

public class EventManagementSystem {
    private static Map<Integer, Event> eventMap = new HashMap<>();
    private static Map<Integer, List<Event>> participantEventMap = new HashMap<>();

    // (a) Add a New Event
    public static void addEvent(int eventId, String eventName, LocalDate eventDate, String eventType) {
        Event event = new Event(eventId, eventName, eventDate, eventType);
        eventMap.put(eventId, event);
        System.out.println("Event added successfully.");
    }

    // (b) Register a Participant for an Event
    public static void registerParticipant(int eventId, Participant participant) {
        if (eventMap.containsKey(eventId)) {
            Event event = eventMap.get(eventId);
            event.addParticipant(participant);

            participantEventMap.computeIfAbsent(participant.getParticipantId(), k -> new ArrayList<>()).add(event);
            System.out.println("Participant registered successfully for event: " + event.getEventName());
        } else {
            System.out.println("Event ID not found.");
        }
    }

    // (c) Display All Events Sorted by Date
    public static void displayEventsSortedByDate() {
        List<Event> sortedEvents = new ArrayList<>(eventMap.values());
        sortedEvents.sort(Comparator.comparing(Event::getEventDate));
        sortedEvents.forEach(System.out::println);
    }

    // (d) Search for an Event by Name
    public static void searchEventByName(String eventName) {
        Optional<Event> event = eventMap.values().stream()
                .filter(e -> e.getEventName().equalsIgnoreCase(eventName))
                .findFirst();
        event.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Event not found.")
        );
    }

    // (e) List All Participants in an Event
    public static void listParticipants(int eventId) {
        if (eventMap.containsKey(eventId)) {
            List<Participant> participants = eventMap.get(eventId).getParticipantsList();
            if (participants.isEmpty()) {
                System.out.println("No participants registered for this event.");
            } else {
                participants.forEach(System.out::println);
            }
        } else {
            System.out.println("Event ID not found.");
        }
    }

    // (f) Remove a Participant from an Event
    public static void removeParticipant(int eventId, int participantId) {
        if (eventMap.containsKey(eventId)) {
            Event event = eventMap.get(eventId);
            event.removeParticipant(participantId);
            System.out.println("Participant removed successfully.");
        } else {
            System.out.println("Event ID not found.");
        }
    }

    // (g) Display Events Where a Given Participant is Registered
    public static void displayEventsForParticipant(int participantId) {
        List<Event> events = participantEventMap.get(participantId);
        if (events != null && !events.isEmpty()) {
            events.forEach(System.out::println);
        } else {
            System.out.println("No events found for this participant.");
        }
    }

    // (h) Filter Events by Type
    public static void filterEventsByType(String eventType) {
        List<Event> filteredEvents = eventMap.values().stream()
                .filter(e -> e.getEventType().equalsIgnoreCase(eventType))
                .collect(Collectors.toList());

        if (filteredEvents.isEmpty()) {
            System.out.println("No events found of type: " + eventType);
        } else {
            filteredEvents.forEach(System.out::println);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Add Events
        addEvent(1, "Tech Conference", LocalDate.of(2025, 4, 15), "Conference");
        addEvent(2, "Music Concert", LocalDate.of(2025, 5, 20), "Concert");
        addEvent(3, "Java Workshop", LocalDate.of(2025, 3, 10), "Workshop");

        // Register Participants
        Participant p1 = new Participant(101, "John Doe", 28, "john@example.com", "9876543210");
        Participant p2 = new Participant(102, "Jane Smith", 25, "jane@example.com", "9123456789");

        registerParticipant(1, p1);
        registerParticipant(2, p1);
        registerParticipant(3, p2);

        // Display All Events Sorted by Date
        System.out.println("\n--- All Events Sorted by Date ---");
        displayEventsSortedByDate();

        // Search Event by Name
        System.out.println("\n--- Search Event by Name ---");
        searchEventByName("Java Workshop");

        // List Participants in an Event
        System.out.println("\n--- Participants in Event ID 1 ---");
        listParticipants(1);

        // Remove a Participant
        System.out.println("\n--- Removing Participant 101 from Event 1 ---");
        removeParticipant(1, 101);

        // Display Events Where a Participant is Registered
        System.out.println("\n--- Events for Participant 101 ---");
        displayEventsForParticipant(101);

        // Filter Events by Type
        System.out.println("\n--- Filter Events by Type: Workshop ---");
        filterEventsByType("Workshop");
    }
}