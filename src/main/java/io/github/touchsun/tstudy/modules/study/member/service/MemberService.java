package io.github.touchsun.tstudy.modules.study.member.service;

import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import io.github.touchsun.tstudy.modules.study.member.model.Member;
import io.github.touchsun.tstudy.modules.study.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* MemberService Class
*
* @author touchsun
* @since 2024/7/25 22:25
*/
@Service
public class MemberService extends AbstractBaseService<Member, String> {

    @Autowired
    public MemberService(MemberRepository repository) {
        super(repository);
    }

}

