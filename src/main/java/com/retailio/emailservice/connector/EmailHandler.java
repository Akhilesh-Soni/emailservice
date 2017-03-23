package com.retailio.emailservice.connector;


import com.retailio.emailservice.util.EmailTask;

public class EmailHandler implements Handler {

    /**
     * Handle the mail request, will create a new {@link EmailTask} for every request.
     * send it to the {@link EmailProviderExecutorService} to submit the task.
     * **/
    @Override
    public void handleEmail(final EmailDto emailDto) {
        EmailTask emailTask = new EmailTask(emailDto);
        EmailProviderExecutorService.submitEmail(emailTask);
    }
}
