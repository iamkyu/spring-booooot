package io.iamkyu.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kj Nam
 * @since 2017-04-08
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCreateRequest {
    /**
     * ArticleCreateRequest 의 용도.
     * Article 에서 created 라는 게시물의 작성일자는 객체 내부적으로 처리한다.
     * 즉, 외부에서 Set 을 할 일이 없다.
     * 따라서 해당 객체(Article)를 통해서 레이어간 데이터를 나르거나 하면
     * 빈 필드 (created)를 계속 포함하게 되며 오용될 가능성이 있다.
     */
    private Long id;
    private String title;
    private String author;
    private String body;
}
