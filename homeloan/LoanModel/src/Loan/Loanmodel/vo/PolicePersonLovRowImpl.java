package Loan.Loanmodel.vo;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Nov 06 22:14:21 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PolicePersonLovRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        Code,
        Name,
        Namenp,
        Position,
        CurrentUnit,
        AppModule_RankLov1_1,
        RankLov1;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int CODE = AttributesEnum.Code.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int NAMENP = AttributesEnum.Namenp.index();
    public static final int POSITION = AttributesEnum.Position.index();
    public static final int CURRENTUNIT = AttributesEnum.CurrentUnit.index();
    public static final int APPMODULE_RANKLOV1_1 = AttributesEnum.AppModule_RankLov1_1.index();
    public static final int RANKLOV1 = AttributesEnum.RankLov1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PolicePersonLovRowImpl() {
    }
}

