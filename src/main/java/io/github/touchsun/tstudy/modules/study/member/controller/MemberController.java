package io.github.touchsun.tstudy.modules.study.member.controller;

import io.github.touchsun.tstudy.common.controller.AbstractBaseController;
import io.github.touchsun.tstudy.modules.study.member.model.Member;
import io.github.touchsun.tstudy.modules.study.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* MemberController Class
* web controller for Member
*
* @author touchsun
* @since 2024/7/25 22:23
*/
@RestController
@RequestMapping("/v1/study/member")
public class MemberController extends AbstractBaseController<Member, String> {

    @Autowired
    public MemberController(MemberService service) {
        super(service);
    }

}
