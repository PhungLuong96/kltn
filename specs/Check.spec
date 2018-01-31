Test Add Patient
=====================
Created by luong96 on 12/20/2017

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
Đăng nhập với Doctor
----------------
*Đăng nhập với "doctor@gmail.com" và "Methadone@2017"

Test mobile field
----------------
*Tài khoản bác sĩ
|url|TestData|DataPrepare|
|http://methadone2.cloudapp.net/main/patients/new|C:\\Users\\luong96\\IdeaProjects\\Demo_KLTN\\src\\test\\java\\DataTest\\TestData_Mobiphone.json|C:\\Users\\luong96\\IdeaProjects\\Demo_KLTN\\src\\test\\java\\DataTest\\DataPrepare_AddPatient.json|

Test Date of birth field
------------------------
*Tài khoản bác sĩ
|url|TestData|DataPrepare|
|http://methadone2.cloudapp.net/main/patients/new|C:\\Users\\luong96\\IdeaProjects\\Demo_KLTN\\src\\test\\java\\DataTest\\TestData_DoBirth.json|C:\\Users\\luong96\\IdeaProjects\\Demo_KLTN\\src\\test\\java\\DataTest\\DataPrepare_AddPatient.json|

Test New Dosage field
---------------------
*Add a drug
|url|TestData|DataPrepare|
|http://methadone2.cloudapp.net/main/patients/8914/detail/executive_info|C:\\Users\\luong96\\IdeaProjects\\Demo_KLTN\\src\\test\\java\\DataTest\\TestData_NewDosage.json|C:\\Users\\luong96\\IdeaProjects\\Demo_KLTN\\src\\test\\java\\DataTest\\DataPrepare_AddDrug.json|
