package com.github.java4wro.event;

import com.github.java4wro.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping(value = "/add")
    private EventDTO add(@RequestBody EventDTO eventDTO) {
        return eventService.addEvent(eventDTO);
    }

    @GetMapping("/findByUuid/{uuid}")
    public EventDTO findAllEvent(@PathVariable("uuid") String eventUuid) {
        return eventService.getEventByUuid(eventUuid);
    }

    @GetMapping("/findByTitle")
    public List<EventDTO> findAllEventsByTitle(@RequestParam("title") String eventTitle) {
        return eventService.getEventsByTitle(eventTitle);
    }

    @DeleteMapping("/deleteByUuid")
    public void deleteEventByUUid(@RequestParam("uuid") String eventUuid) {
        EventDTO deleteEvent = eventService.getEventByUuid(eventUuid);
        if (deleteEvent == null) {
            throw new EventNotFoundException(eventUuid);
        }
        eventService.deleteEventByUuid(eventUuid);
    }

    //Input data format: 2007-12-03T10:15:30Z
    @GetMapping("/findByDate/{date1}/{date2}")
    public List<EventDTO> findAllByDateTimeBetween(@PathVariable(value = "date1", required = false) String date1,
                                                   @PathVariable(value = "date2", required = false) String date2) {
        return eventService.findAllByDateTimeBetween(date1, date2);
    }
}
