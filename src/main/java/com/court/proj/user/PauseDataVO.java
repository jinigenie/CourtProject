package com.court.proj.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PauseDataVO {
	
    private int pause_proper_num;
    private String accept_status;
    private int accept_proper_num;
    private String pause_start_date;
    private String pause_end_date;
    private String pause_submit_date;
    private String accept_pause_etc;
}
