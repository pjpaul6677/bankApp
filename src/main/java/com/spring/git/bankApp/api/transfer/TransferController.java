package com.spring.git.bankApp.api.transfer;

import com.spring.git.bankApp.domain.transfer.TransferCommand;
import com.spring.git.bankApp.domain.transfer.TransferFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferFacade transferFacade;

    @PostMapping(path = "/transfer")
    public void createTransfer(@RequestBody TransferDto transferDto) {
        transferFacade.createTransfer(transferDto.getFromAccountNumber(), transferDto.getToAccountNumber(), transferDto.getAmount());
    }

    @PostMapping(path = "/transfers")
    public void createMultipleTransfersWithNumbers(@RequestBody List<TransferDto> transferDtos) {
        transferFacade.createMultipleTransfersWithNumbers(transferDtos);
    }

    @PostMapping(path = "/transferswithid")
    public void createMultipleTransfersWithIds(@RequestBody List<TransferCommand> transfers) {
        transferFacade.multipleTransfersWithIds(transfers);
    }


}
