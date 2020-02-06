package info.xpanda.labs.admin.service.user.remoting;


public class SystemRemotingHystrix implements SystemRemoting {
    @Override
    public String info() {
        return "Call System Error: info";
    }
}
