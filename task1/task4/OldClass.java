package task4;

@DeprecatedEx(message = "Use NewClass instead")
public class OldClass {
    @DeprecatedEx(message = "Use newMethod() instead")
    public void oldMethod() {}
    
    public void regularMethod() {}
}