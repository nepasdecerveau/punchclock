package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.EntryCreate;
import ch.zli.m223.punchclock.service.DepartmentService;
import ch.zli.m223.punchclock.service.EntryService;
import ch.zli.m223.punchclock.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;
    private DepartmentService departmentService;
    private ProjectService projectService;

    public EntryController(EntryService entryService, DepartmentService departmentService, ProjectService projectService) {
        this.entryService = entryService;
        this.departmentService = departmentService;
        this.projectService = projectService;
    }

    @DeleteMapping(value ="/{id}")
    public void deleteEntry(@PathVariable long id){
        entryService.deleteEntry(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody EntryCreate entryCreate) {
        Entry entry = new Entry();
        entry.setId(entryCreate.getId());
        entry.setCheckIn(entryCreate.getCheckIn());
        entry.setCheckOut(entryCreate.getCheckOut());
        entry.setDepartment(departmentService.findById(entryCreate.getDepartmentId()).get());
        entry.setProject(projectService.getById(entryCreate.getProjectId()).get());

        return entryService.createEntry(entry);
    }

    @PutMapping
    public void updateEntry(@Valid @RequestBody EntryCreate entryCreate){
        Entry entry = new Entry();

        entry.setId(entryCreate.getId());
        entry.setCheckIn(entryCreate.getCheckIn());
        entry.setCheckOut(entryCreate.getCheckOut());
        entry.setDepartment(departmentService.findById(entryCreate.getDepartmentId()).get());
        entry.setProject(projectService.getById(entryCreate.getProjectId()).get());

        entryService.updateEntry(entry);
    }
}
