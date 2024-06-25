import {test,expect} from '@playwright/test';
import {LoginPage} from '../pageObjects/LoginPage';
import {DashboardPage} from '../pageObjects/DashboardPage';
import {EmployeeListPage} from '../pageObjects/EmployeeListPage';
import {EmployeeDetailsPage} from '../pageObjects/EmployeeDetailsPage';



let firstName = "Jason"
let lastName = "Matthew"

test('test_update_employee @regression',async({page}) => {
    const login = new LoginPage(page);
    await login.login();
    const dashboard = new DashboardPage(page);
    await dashboard.goToEmployeeListPage();
    const empList = new EmployeeListPage(page);
    await empList.enterEmployeeName(firstName);
    await empList.clickSearchButton();
    await page.waitForTimeout(2000);
    await empList.clickUpdate(firstName, lastName);
    await page.waitForTimeout(2000);
    await empList.checkEmployeeDetailsURL();
    const empDetails = new EmployeeDetailsPage(page)
    await empDetails.updateEmployeeDetails();
    await empDetails.clickSave();
    

});

