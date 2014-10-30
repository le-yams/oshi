/**
 * Copyright (c) Daniel Doubrovkine, 2010 dblock[at]dblock[dot]org All Rights
 * Reserved Eclipse Public License (EPLv1) http://oshi.codeplex.com/license
 */
package oshi.software.os.unix;

import java.util.HashMap;
import java.util.Map;
import jna.platform.unix.LibCWrapper;
import jna.platform.unix.UNameInfo;
import lombok.Getter;
import oshi.software.os.OperatingSystem;

/**
 * Microsoft Windows is a family of proprietary operating systems most commonly
 * used on personal computers.
 *
 * @author dblock[at]dblock[dot]org
 */
public class UnixOperatingSystem implements OperatingSystem {

    @Getter
    private final String family;
    
    @Getter
    private final String manufacturer;
    
    @Getter
    private final UnixOperatingSystemVersion version;

    public UnixOperatingSystem() {
        UNameInfo info = LibCWrapper.uname();
        family = parseFamily(info);
        manufacturer = parseManufacturer(info);
        version = UnixOperatingSystemVersion.of(info);
    }

    private static String parseFamily(UNameInfo info) {
        String family = familiesForSysname.get(info.getSysname());
        // TODO: handle if null
        throw new UnsupportedOperationException("not implemented yet");
    }
    
    private static String parseManufacturer(UNameInfo info) {
        String manufacturer = manufacturersForSysname.get(info.getSysname());
        // TODO: handle if null
        throw new UnsupportedOperationException("not implemented yet");
    }
    
    private static final Map<String, String> familiesForSysname = new HashMap<String, String>();
    private static final Map<String, String> manufacturersForSysname = new HashMap<String, String>();
    static {
        familiesForSysname.put("Linux", "Linux");
        familiesForSysname.put("DragonFly", "BSD");
        familiesForSysname.put("FreeBSD", "BSD");
        familiesForSysname.put("NetBSD", "BSD");
        familiesForSysname.put("Darwin", "BSD");
        familiesForSysname.put("Haiku", "BeOS");
        familiesForSysname.put("HP-UX", "Unix");
        familiesForSysname.put("AIX", "Unix");
        familiesForSysname.put("OS400", "Unix");
        familiesForSysname.put("IRIX", "Unix");
        familiesForSysname.put("SunOS", "Unix");
        familiesForSysname.put("ULTRIX", "Unix");
        familiesForSysname.put("UnixWare", "Unix");
        
        
        manufacturersForSysname.put("HP-UX", "Hewlett-Packard");
        manufacturersForSysname.put("AIX", "IBM");
        manufacturersForSysname.put("OS400", "IBM");
        manufacturersForSysname.put("IRIX", "Silicon Graphics");
        manufacturersForSysname.put("Darwin", "Apple");
        manufacturersForSysname.put("SunOS", "Sun Microsystems");
        manufacturersForSysname.put("ULTRIX", "Digital Equipment Corporation");
        manufacturersForSysname.put("UnixWare", "Xinuos");
        
    }
}
