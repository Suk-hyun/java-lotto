package lotto.controller;

import lotto.utils.LottoMaker;
import lotto.service.LottoService;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    LottoService service = new LottoService();

    public void run() {
        int purchaseMoneyInt;
        int countOfLottoToMake;

        InputView.requestPurchaseMoney();// 돈받고 몇장 구매한건지 알림
        String purchaseMoneyInput = InputView.readPurchaseMoney();
        purchaseMoneyInt = Parser.stringToInt(purchaseMoneyInput);
        countOfLottoToMake = LottoMaker.calculateCountOfLottoToMake(purchaseMoneyInt);
        OutputView.countOfLotto(countOfLottoToMake);

        LottoMaker.makeAllLotto(service, countOfLottoToMake); // 모든 로또 만들고 출력

        OutputView.allLotto(service.getAllLotto());


        InputView.requestWinningNumber(); // 당첨 번호 받고 바꾸기.
        String winningNumberInput = InputView.readWinningNumber();

        List<Integer> winningNumbers = new ArrayList<>();
        String[] winningNumberSplit = Parser.splitByComma(winningNumberInput);
        for (String s : winningNumberSplit) {
            winningNumbers.add(Parser.stringToInt(s));
        }

        InputView.requestBonusNumber();
        String bonusNumber = InputView.readBonusNumber();
        int bonusNum = Integer.parseInt(bonusNumber);

        service.computeScore(winningNumbers, bonusNum); // 핵심로직

        OutputView.resultMessage();
        OutputView.allScore();
        int earningRate = service.computeEarningRate(purchaseMoneyInt);
        OutputView.earningRate(earningRate);
    }
}
