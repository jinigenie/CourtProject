package com.court.proj.aplcnReg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CertiVO {

    @JsonProperty("종목명")
    private String certiName;

    private String searchkeyword;

}
