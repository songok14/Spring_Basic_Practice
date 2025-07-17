package com.gooseBumps.member_practice.member.conteoller;

import com.gooseBumps.member_practice.member.dto.MemberCreateDto;
import com.gooseBumps.member_practice.member.dto.MemberDetailDto;
import com.gooseBumps.member_practice.member.dto.MemberListDto;
import com.gooseBumps.member_practice.member.dto.MemberUpMessage;
import com.gooseBumps.member_practice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberContoroller {
    private final MemberService memberService;

    // 회원 가입
    @PostMapping("/create")
    public String save(@RequestBody MemberCreateDto memberCreateDto){
        memberService.save(memberCreateDto);
        return "ok";
    }

    // 회원 조회
    @GetMapping("/list")
    public List<MemberListDto> list(){
        return memberService.list();
    }

    // 회원 상세
    @GetMapping("/detail/{memberSeq}")
    public MemberDetailDto detail(@PathVariable Long memberSeq){
        return memberService.detail(memberSeq);
    }

    // 상태메세지 변경
    @PatchMapping("/update/statusmessage")
    public String updateMessage(@RequestBody MemberUpMessage memberUpMessage){
        memberService.updateMessage(memberUpMessage);
        return "ok";
    }

    // 회원 탈퇴
    @DeleteMapping("/delete/{memberSeq}")
    public String delete(@PathVariable Long memberSeq){
        memberService.delete(memberSeq);
        return "ok";
    }
}
