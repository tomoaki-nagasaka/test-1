
@Autowired
private UserRepository userRepository;
@Autowired
private AuthorityRepository authorityRepository;

@RequestMapping(value = "signup", method = RequestMethod.GET)
public String signup() {
    return "signup";
}

@RequestMapping(value = "signup", method = RequestMethod.POST)
public String signup(@RequestParam String username, @RequestParam String password) {
    userdata user = new User();
    user.setCustid(custid);
    user.setUsername(username);
    user.setOrgname(orgname);
    user.setPassword(password);
    userRepository.save(user);

    return "signup";
}

