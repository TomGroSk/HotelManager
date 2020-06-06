package pl.gromadzki.manager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gromadzki.manager.Entity.Client;
import pl.gromadzki.manager.Entity.POJO.RoomType;
import pl.gromadzki.manager.Entity.Room;
import pl.gromadzki.manager.Repository.RoomRepository;

@Controller
@RequestMapping("/room")
public class RoomController {

    final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public String getRoomIndex(Model model){
        model.addAttribute("room", new Room());
        model.addAttribute("roomType", RoomType.values());
        model.addAttribute("rooms", roomRepository.findAll());
        return "room";
    }
    @PostMapping
    public String addRoom(@ModelAttribute Room room){
        roomRepository.save(room);
        return "redirect:/room";
    }

    @GetMapping("/edit/{id}")
    public String editRoom(@ModelAttribute("id") Long id, Model model){
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
        model.addAttribute("updatingRoom", room);
        model.addAttribute("roomType", RoomType.values());
        return "editRoom";
    }

    @PostMapping("/edit/{id}")
    public String updateRoom(@ModelAttribute("room") Room room){
        roomRepository.save(room);
        return "redirect:/room";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@ModelAttribute("id") Long id){
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
        roomRepository.delete(room);
        return "redirect:/room";
    }
}
