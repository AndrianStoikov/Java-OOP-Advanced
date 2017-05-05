package P04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrian on 16.3.2017 г..
 */
public class Smartphone implements Callable, Browseable{
    private List<String> numbers;
    private List<String> sites;

    public Smartphone() {
        this.numbers = new ArrayList<>();
        this.sites = new ArrayList<>();
    }

    public void addNumber(String number) {
        this.numbers.add(number);
    }

    public void addSite(String site) {
        this.sites.add(site);
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.numbers) {
            if(!number.matches(".*[A-Za-z]+.*"))
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            else
                sb.append("Invalid number!").append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String site : this.sites) {
            if(!site.matches(".*\\d+.*"))
                sb.append("Browsing: ").append(site).append("!").append(System.lineSeparator());
            else
                sb.append("Invalid URL!").append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
