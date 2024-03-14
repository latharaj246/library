package com.library.lms.Controller;


import com.library.lms.model.Member;
import com.library.lms.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public String listMember(Model model){
        model.addAttribute("members", memberRepository.findAll());
        return "members";

    }
@GetMapping("/member/new")
    public String showCreateForm(Model model){
    Member member = new Member();
    model.addAttribute("member",member);
    return "create_member";
    }

    @PostMapping("/members")
    public String saveMember(Member member){
        memberRepository.save(member);
        return "redirect:/members";
    }
}
