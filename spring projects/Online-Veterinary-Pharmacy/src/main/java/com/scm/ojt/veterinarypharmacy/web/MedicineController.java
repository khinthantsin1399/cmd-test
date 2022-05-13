package com.scm.ojt.veterinarypharmacy.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.scm.ojt.veterinarypharmacy.bl.service.MedicineService;
import com.scm.ojt.veterinarypharmacy.entity.Medicine;

/**
 * <h2>MedicineController Class</h2>
 * <p>
 * Process for Displaying medicineController
 * </p>
 * 
 * @author khinthantsin
 *
 */
/**
 *<h2> MedicineController Class</h2>
 * <p>
 * Process for Displaying MedicineController
 * </p>
 *@author khinthantsin
 *
 */
/**
 * <h2>MedicineController Class</h2>
 * <p>
 * Process for Displaying MedicineController
 * </p>
 * 
 * @author khinthantsin
 *
 */
@Controller
@RequestMapping("/medicine")
public class MedicineController {
    /**
     * <h2>medicineService</h2>
     * <p>
     * medicineService
     * </p>
     */
    @Autowired
    private MedicineService medicineService;

    /**
     * <h2>listmedicines</h2>
     * <p>
     * method to show medicine list
     * </p>
     * 
     * @param model
     * @return
     * @return String
     */
    @GetMapping("/list")
    public String listMedicines(Model model) {
        List<Medicine> theMedicines = medicineService.getMedicineList();
        model.addAttribute("medicines", theMedicines);
        return "MedicineList";
    }

    /**
     * <h2>showAddForm</h2>
     * <p>
     * Method to show add form
     * </p>
     * 
     * @param model
     * @return
     * @return String
     */
    @GetMapping("/showForm")
    public String showAddForm(Model model) {
        Medicine theMedicine = new Medicine();
        model.addAttribute("medicine", theMedicine);
        return "MedicineAddForm";
    }

    /**
     * <h2>savemedicine</h2>
     * <p>
     * Method to save medicine record
     * </p>
     * 
     * @param themedicine
     * @param bindingResult
     * @return
     * @return String
     */
    @PostMapping("/saveMedicine")
    public String saveMedicine(@Valid @ModelAttribute("medicine") Medicine theMedicine, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "MedicineAddForm";
        } else {
            medicineService.saveMedicine(theMedicine);
            return "redirect:/medicine/list";
        }
    }

    /**
     * <h2>showUpdateForm</h2>
     * <p>
     * Method to show update form
     * </p>
     * 
     * @param theId
     * @param model
     * @return
     * @return String
     */
    @GetMapping("/updateForm")
    public String showUpdateForm(@RequestParam("medicineId") int theId, Model model) {
        Medicine theMedicine = medicineService.getMedicine(theId);
        model.addAttribute("medicine", theMedicine);
        return "MedicineAddForm";
    }

    /**
     * <h2>deletemedicine</h2>
     * <p>
     * Method to delete medicine record
     * </p>
     * 
     * @param theId
     * @return
     * @return String
     */
    @GetMapping("/delete")
    public String deleteMedicine(@RequestParam("medicineId") int theId) {
        medicineService.deleteMedicine(theId);
        return "redirect:/medicine/list";
    }

    /**
     * <h2>getFile</h2>
     * <p>
     * Method to download data from database as excel file
     * </p>
     * 
     * @return
     * @return ResponseEntity<InputStreamResource>
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getFile() {
        String filename = "medicine.xlsx";
        InputStreamResource file = new InputStreamResource(medicineService.load());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
    }

    /**
     * <h2>uploadExcel</h2>
     * <p>
     * Method to upload excel file and save to database
     * </p>
     * 
     * @param file
     * @param request
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
    public ModelAndView uploadExcel(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        ModelAndView uploadView = new ModelAndView("uploadExcel");
        this.medicineService.save(file);
        uploadView = new ModelAndView("redirect:/medicine/list");
        return uploadView;
    }
}
