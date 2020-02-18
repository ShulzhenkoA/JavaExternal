package org.javaexternal_shulzhenko.droidswar.console;

import org.javaexternal_shulzhenko.droidswar.account.Account;
import org.javaexternal_shulzhenko.droidswar.droids.Droid;
import org.javaexternal_shulzhenko.droidswar.utils.ResourceBundleUtil;

public class ConsoleView {

    private static final String STARS_LINE = "\n****************************************************************\n";

    public static void showResultsOfTheFight(Droid firstDroid, Droid secondDroid) {

        String firstDroidInfo = firstDroid.toString();
        String secondDroidInfo = secondDroid.toString();

        if (!firstDroid.isAlive()) {
            firstDroidInfo = firstDroid.getName() + firstDroid.getModel() +
                    ResourceBundleUtil.INSTANCE.getString("droidswar.language.was.defeated");
        }

        if (!secondDroid.isAlive()) {
            secondDroidInfo = secondDroid.getName() + secondDroid.getModel() +
                    ResourceBundleUtil.INSTANCE.getString("droidswar.language.was.defeated");
        }

        String betweenInfo = buildStringMassage(
                ResourceBundleUtil.INSTANCE.getString("droidswar.language.between"), firstDroid.getName() ,
                firstDroid.getModel(),
                ResourceBundleUtil.INSTANCE.getString("droidswar.language.and"),
                secondDroid.getName(), secondDroid.getModel());

        String equalSignsLine = "";

        for (int i = 0; i < betweenInfo.length(); i++) {
            equalSignsLine = buildStringMassage(equalSignsLine, "=");
        }

        String allBattleInfo = buildStringMassage("\n\n" , equalSignsLine,
                ResourceBundleUtil.INSTANCE.getString("droidswar.language.result.of.battle"),
                betweenInfo, ResourceBundleUtil.INSTANCE.getString("droidswar.language.surviving.droid.info"),
                equalSignsLine, STARS_LINE, firstDroidInfo,
                STARS_LINE, secondDroidInfo, STARS_LINE);

        System.out.println(allBattleInfo);
    }

    public static void printDroidInfo(Droid droid) {
        String droidInfo = buildStringMassage(
                ResourceBundleUtil.INSTANCE.getString("droidswar.language.droidinfo.header"),
                droid.toString(),
                ResourceBundleUtil.INSTANCE.getString("droidswar.language.droidinfo.header"));
        System.out.println(droidInfo);
    }

    public static void printBattleBetweenHeader() {
        System.out.println(ResourceBundleUtil.INSTANCE.getString("droidswar.language.battle.between.header"));
    }

    public void printGreeting() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.this.is.droids.menu"));
    }

    public void printCreatingAccHeader() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.account.creating.header"));
    }

    public void printEnterNickName() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.enter.your.nickname.creating"));
    }

    public void printEnterPassword() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.enter.your.password.creating"));
    }

    public void printCreateAdmOrUserAcc() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.do.you.want.admin.creating"));
    }

    public void printAccountCreated() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.your.account.was.created"));
    }

    public void printLoginAccountHeader() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.login.account.header"));
    }

    public void printEnterForLogin() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.enter.your.account.nickname.login"));
    }

    public void printEnterPasswordForLogin() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.enter.your.account.password.login"));
    }

    public void printInvalidNickname() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.this.nickname.exist.creating"));
    }

    public void printInvalidPassword() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.your.password.invalid.creating"));
    }

    public void printWrongNicknameOrPassword() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.this.account.dont.exist"));
    }

    public void printUserAccHeader(Account account) {

        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.logged.in.user.header") +
                        account.getNickname() +
                        ResourceBundleUtil.INSTANCE.getString("droidswar.language.logged.in.user.menu"));
    }

    public void printAdminAccHeader(Account account) {

        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.logged.in.admin.header") +
                account.getNickname() +
                ResourceBundleUtil.INSTANCE.getString("droidswar.language.logged.in.admin.menu"));
    }

    public void printWhichDroidCreate(Account account) {

        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.logged.in.admin.header") +
                account.getNickname() +
                ResourceBundleUtil.INSTANCE.getString("droidswar.language.logged.in.admin.create.droid.menu"));
    }

    public void printDroidWasCreated(Droid droid) {
        printDroidInfo(droid);
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.was.successfully.created"));
    }

    public void printDroidWasDeleted() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.was.successfully.deleted"));
    }

    public void printEmptyDroidsList() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.droidlist.is.empty"));
    }

    public void printDroid(Droid droid){
        printDroidInfo(droid);
    }

    public void printDroidNumberInDroidList(int number) {
        printToConsole(
                ResourceBundleUtil.INSTANCE.getString("droidswar.language.droid.number.in.droidslist") +
                        number + " ...");
    }

    public void printChooseTwoDroids() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.choose.two.droids"));
    }

    public void printChooseSecondDroid() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.enter.number.second.droid"));
    }

    public void printChooseDroidForDeleting() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.enter.number.droid.delete"));
    }

    public void printCorrectDroidNumbers() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.choose.enter.correct.numbers"));
    }

    public void printDroidsListHeader(){
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.droidlist.header"));
    }

    public void printBattleBetweenSameDroids() {
        printToConsole(ResourceBundleUtil.INSTANCE.getString("droidswar.language.battle.between.same"));
    }

    private void printToConsole(String massage){
        System.out.println(massage);
    }

    private static String buildStringMassage(String... message){
        StringBuilder buildMassage = new StringBuilder();
        for(String s : message) {
            buildMassage = buildMassage.append(s);
        }
        return new String(buildMassage);
    }

}
