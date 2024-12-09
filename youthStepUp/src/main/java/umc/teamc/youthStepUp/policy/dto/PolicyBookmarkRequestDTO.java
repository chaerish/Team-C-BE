package umc.teamc.youthStepUp.policy.dto;

import lombok.Getter;
import umc.teamc.youthStepUp.member.entity.Member;
import umc.teamc.youthStepUp.policy.entity.BookMarkPolicy;
import umc.teamc.youthStepUp.policy.entity.Policy;

public class PolicyBookmarkRequestDTO {

    @Getter
    public static class CreateBookmarkDTO {
        public BookMarkPolicy toEntity(Member member, Policy policy) {
            return BookMarkPolicy.builder()
                    .member(member)
                    .policy(policy)
                    .isCompleted(false)
                    .build();
        }
    }

    @Getter
    public static class CreatePolicyDTO {

        public Policy toEntity(String srchPolicyId, String deadline) {
            return Policy.builder()
                    .srchPolicyId(srchPolicyId)
                    .deadline(deadline)
                    .build();
        }
    }
}
