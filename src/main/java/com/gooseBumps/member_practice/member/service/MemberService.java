package com.gooseBumps.member_practice.member.service;

import com.gooseBumps.member_practice.member.domain.Member;
import com.gooseBumps.member_practice.member.dto.MemberCreateDto;
import com.gooseBumps.member_practice.member.dto.MemberDetailDto;
import com.gooseBumps.member_practice.member.dto.MemberListDto;
import com.gooseBumps.member_practice.member.dto.MemberUpMessage;
import com.gooseBumps.member_practice.member.repogitory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원 가입
    public void save(MemberCreateDto memberCreateDto){
        if (memberRepository.findByEmail(memberCreateDto.getEmail()).isPresent()){
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }
        Member member = memberCreateDto.memberToEntity();
        memberRepository.save(member);
    }

    // 회원 조회
    @Transactional(readOnly = true)
    public List<MemberListDto> list(){
        return memberRepository.findAll().stream().map(a -> MemberListDto.fromEntity(a)).collect(Collectors.toList());
    }

    // 회원 상세
    @Transactional(readOnly = true)
    public MemberDetailDto detail(Long memberSeq){
        Member member = memberRepository.findById(memberSeq).orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원번호입니다."));
        return MemberDetailDto.fromEntity(member);
    }

    // 상태메세지 업데이트
    public void updateMessage(MemberUpMessage memberUpMessage){
        Member member = memberRepository.findByEmail(memberUpMessage.getEmail()).orElseThrow(() -> new NoSuchElementException("존재하지 않는 이메일입니다."));
        member.updateMessage(memberUpMessage.getStatusMessage());
    }

    // 회원 탈퇴
    public void delete(Long memberSeq){
        Member member = memberRepository.findById(memberSeq).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원번호입니다."));
        memberRepository.delete(member);
    }
}
