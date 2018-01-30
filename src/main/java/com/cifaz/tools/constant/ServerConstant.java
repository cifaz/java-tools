package com.cifaz.tools.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServerConstant {
    public ServerConstant() {
    }

    public static class PermissionSystemType {
        public static final Integer BOSS = 1;
        public static final Integer CRM = 2;
        public static final Integer B2B_PC = 3;
        public static final Integer B2B_H5 = 4;
        public static final Integer B2B_ADMIN = 5;

        public PermissionSystemType() {
        }
    }

    public static class TerminalType {
        public static final Integer ALL = 0;
        public static final Integer ANDROID = 1;
        public static final Integer IOS = 2;
        public static final Integer WIN_PHONE = 3;
        public static final Integer WIN_PAD = 4;
        public static final Integer WECHAT = 5;
        public static final Integer WEB = 6;
        public static final Integer OTHER = 7;

        public TerminalType() {
        }
    }

    public static class SystemType {
        public static final Integer ALL = 0;
        public static final Integer BUYER = 1;
        public static final Integer SELLER = 2;
        public static final Integer WAP = 3;
        public static final Integer WECHAT = 4;
        public static final Integer BOSS = 5;
        public static final Integer IM = 6;
        public static final Integer PUSH = 7;
        public static final Integer SOA_SERVER = 8;
        public static final Integer OPERATIONS = 9;
        public static final Integer PROMO = 10;
        public static final Integer SOA_PROMO = 11;
        public static final Integer SOA_COMMUNITY = 12;
        public static final List<Integer> SYSTEMTYPE =
                new ArrayList(Arrays.asList(
                        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));

        public SystemType() {
        }
    }

    public static class AppType {
        public static final Integer OTHER = 0;
        public static final Integer BUYER = 1;
        public static final Integer SELLER = 2;
        public static final Integer WAP = 4;
        public static final Integer WECHAT = 8;
        public static final Integer ALL = 15;

        public AppType() {
        }
    }

    public static class Error {
        public static final Integer SUCCESS = 0;
        public static final Integer SYSTEM_INNER_ERROR = 10001;
        public static final Integer CALL_SERVER_INTERFACE_FAIL = 20001;
        public static final Integer CALL_OPEN_INTERFACE_FAIL = 30001;
        public static final Integer PARAMS_INAVAILABLE = 40001;
        public static final Integer NO_AVALIABLE_DATA = 50001;
        public static final Integer PERMISSION_DENY = 60001;

        public Error() {
        }
    }
}
