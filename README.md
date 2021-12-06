Bulk Registration
---------------------------

Create Upload CSV file from JSF with following fields:
	MSISDN, SIM_TYPE, NAME, DATE_OF_BIRTH, GENDER, ADDRESS, ID_NUMBER

Function to register SIM:

	- Validation:
		- No field should be empty
		- Name shouldn't have any special character
		- DATE_OF_BIRTH shouldn't be TODAY or FUTURE
		- Age more than 18 year old
		- Gender can only be F or M
		- Address must at least be 20 characters long
		- ID_NUMBER should be a mix of characters & numbers
		- SIM_TYPE can only be PREPAID or POSTPAID
		- MSISDN should comply to country's standard (e.g. +66)
		- MSISDN can't be duplicated

	- For each validated success record, save a new file with name as '<MSISDN>.txt' and put all the info there

	- For each validated success, send welcome SMS to new MSISDN numbers
		- Different message for both genders
		- SMS function can just be log line

	- Console output with status of each registration
		- For each validated failed, print the reason of failure
			
--------------------------


