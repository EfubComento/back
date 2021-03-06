package EFUB.commento.service;

import EFUB.commento.domain.Answer;
import EFUB.commento.domain.AnswerRepository;
import EFUB.commento.dto.AnswerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository){
        this.answerRepository=answerRepository;
    }


//    public List<Answer> getAnswer(Long questionId){
//        return answerRepository.findAllByQuestion_Id(questionId);
//    }
    public Answer getAnswerById(Long id){
        return answerRepository.findAllById(id);
    }
    public List<Answer> getAll(){
        return answerRepository.findAll();
    }

    public void registerAnswer(AnswerDto answerDto){
        Answer answer=new Answer();
        answer.setCompany(answerDto.getCompany());
        answer.setContent(answerDto.getContent());
        answer.setQuestion_id(answerDto.getQuestionId());

        answerRepository.save(answer);
    }

    public void deleteAnswer(Long id){
        answerRepository.deleteById(id);
    }

    public void updateAnswer(Long id, Answer newAnswer){
        Optional<Answer> originalAnswer=answerRepository.findById(id);

        originalAnswer.ifPresent(selectAnswer ->{
            selectAnswer.setCompany(newAnswer.getCompany());
            selectAnswer.setContent(newAnswer.getContent());
            selectAnswer.setQuestion_id(newAnswer.getQuestion_id());
            answerRepository.save(selectAnswer);
        });    }

}
