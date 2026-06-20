package com.IT3930.apartment.controller;

import com.IT3930.apartment.security.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal CustomUserDetails userDetails) {
        String role = userDetails.getAccount().getRole().name();
        return switch (role) {
            case "ADMIN" -> "redirect:/admin/dashboard";
            case "STAFF" -> "redirect:/staff/dashboard";
            case "OWNER" -> "redirect:/owner/dashboard";
            default -> "redirect:/login";
        };
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("account", userDetails.getAccount());
        model.addAttribute("role", "Admin");
        return "dashboard";
    }

    @GetMapping("/staff/dashboard")
    public String staffDashboard(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("account", userDetails.getAccount());
        model.addAttribute("role", "Staff");
        return "dashboard";
    }

    @GetMapping("/owner/dashboard")
    public String ownerDashboard(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("account", userDetails.getAccount());
        model.addAttribute("role", "Owner");
        return "dashboard";
    }
}
