package adapters;

public class SuiteAdapter extends BaseAdapter {

    public String create(String body, int status, String code) {
        return post(body, status, "https://api.qase.io/v1/suite/" + code);
    }
}
