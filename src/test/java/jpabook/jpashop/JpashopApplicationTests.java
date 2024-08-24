package jpabook.jpashop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class JpashopApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	MemberRepository memberRepository;

	@org.junit.Test
	@Transactional
	public void testMember() throws Exception {
		// given
		Member member = new Member();
		member.setUsername("sieun");

		// when
		Long savedId = memberRepository.save(member);
		Member findMember = memberRepository.find(savedId);

		// then
		Assertions.assertEquals(findMember.getId(), member.getId());
		Assertions.assertEquals(findMember.getUsername(), member.getUsername());
	}

}
