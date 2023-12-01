package com.app.controller.controller.task;

import com.app.controller.domain.CompanyVO;
import com.app.controller.domain.ProductVO;
import com.app.controller.domain.StudentVO;
import com.app.controller.service.CompanyService;
import com.app.controller.service.ProductService;
import com.app.controller.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TaskController {
    private final ProductService productService;
    private final StudentService studentService;
    private final CompanyService companyService;

//    [실습 1]
//    외부에서 상품명, 상품가격, 상품재고, 브랜드 전달받아서 화면에 전송
//    화면에서 4개 정보 입력 후 form태그로 전송한다.
//    - product.html
    @GetMapping("/product/write")
    public void goToProductWriteForm(ProductVO productVO){;}

    @PostMapping("/product/write")
    public RedirectView write(ProductVO productVO){
        productService.write(productVO);
        return new RedirectView("/product/write");
    }

//    [실습 2]
//    TaskVO 선언
//    id(학생번호), kor(국어점수), eng(영어점수), math(수학점수) 선언
//    총점과 평균 점수 화면에 출력
//    - register.html
//    - result.html
    @GetMapping("/student/register")
    public void goToStudentRegisterForm(StudentVO studentVO){;}

    @GetMapping("/student/result")
    public void goToResultForm(Model model){
        model.addAttribute("students", studentService.getStudents());
    }

    @PostMapping("/student/register")
    public RedirectView register(StudentVO studentVO){
        studentService.register(studentVO);
        return new RedirectView("/student/result");
    }

//    [실습 3]
//    이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
//    출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
//    출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
//    퇴근 버튼 클릭 시 17시 전이라면 퇴근 아닌 업무시간으로 처리한다.
//    - getToWork.html
//    - leaveWork.html
//    - late.html
//    - work.html

    @GetMapping("/company/get-to-work")
    public void getToWork(){;}

    @GetMapping("/company/leave-work")
    public void leaveWork(){;}

    @GetMapping("/company/late")
    public void late(){;}

    @GetMapping("/company/work")
    public void work(){;}

    @GetMapping("/company/check-in")
    public void goToCheckInForm(){;}

    @PostMapping("/company/check-in")
    public RedirectView checkIn(CompanyVO companyVO, String flag){
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info(format);
        int hour = now.getHour();
        int minute = now.getMinute();

        boolean lateCondition = hour >= 9 && minute > 0;
        boolean leaveWorkCondition = hour >= 17 && minute >= 0;

        if(flag.equals("getToWork")){
            companyVO.setGetToWorkDatetime(format);
            companyService.register(companyVO);
            return new RedirectView(lateCondition ? "/company/late" : "/company/get-to-work");
        }
        companyVO.setLeaveWorkDatetime(format);
        companyService.register(companyVO);
        return new RedirectView(leaveWorkCondition ? "/company/leave-work" : "/company/work");
    }
}











