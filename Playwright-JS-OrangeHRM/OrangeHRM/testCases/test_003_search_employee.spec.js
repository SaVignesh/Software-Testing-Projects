import {test,expect} from '@playwright/test';
import {LoginPage} from '../pageObjects/LoginPage';
import {DashboardPage} from '../pageObjects/DashboardPage';
import {EmployeeListPage} from '../pageObjects/EmployeeListPage';



let firstName = "Jason"
let lastName = "Matthew"

test('test_search_employee@regression',async({page}) => {
    const login = new LoginPage(page);
    await login.login();
    const dashboard = new DashboardPage(page);
    await dashboard.goToEmployeeListPage();
    const empList = new EmployeeListPage(page);
    await empList.enterEmployeeName(firstName);
    await empList.clickSearchButton();
    await page.waitForTimeout(2000);
    await empList.checkEmpName(firstName, lastName);

});

