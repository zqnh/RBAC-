package net.zzqd.beans;

import lombok.*;

import java.util.Set;

/**
 * @author zqnh
 * @date 2019/8/10 on 23:32.
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    private String subject;

    private String message;

    private Set<String> receivers;
}