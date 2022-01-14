# USCIS Case Status Checker
Instead of checking your case status 5 times a day, this project automates the process.

# Run
``./gradlew run --args="case_number"``

# Possible responses:
A valid response would look like:
`Case status: Case Is Being Actively Reviewed By USCIS...`

When an error occurs, you'd get the following error: `Error received: Validation Error(s) You must correct the following error(s) before proceeding...`