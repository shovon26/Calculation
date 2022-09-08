package com.example.calculation;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

public class GetBalance {

    public static BigDecimal getBalance(String ethAddress) {
        BigDecimal scaledBalance = new BigDecimal(0.0);
        System.out.println("Balance then :: " + scaledBalance);
        try {
            final Web3j client = Web3j.build(
                    new HttpService(
                            "https://mainnet.infura.io/v3/f91d1c30825f45e78c3b6186bcac3626"
                    )
            );

            final EthGetBalance balanceResponse = client
                    .ethGetBalance(ethAddress, DefaultBlockParameter.valueOf("latest")).sendAsync()
                    .get(10, TimeUnit.SECONDS);

            final BigInteger unscaledBalance = balanceResponse.getBalance();

            scaledBalance = new BigDecimal(unscaledBalance)
                    .divide(new BigDecimal(1000000000000000000L), 18, RoundingMode.HALF_UP);

            System.out.println("Balance then :: " + scaledBalance);   //Scaled Balance is not found here

        } catch (Exception ex) {
            ex.printStackTrace();
            //System.out.println("Error");
        }
        return scaledBalance;
    }
}
