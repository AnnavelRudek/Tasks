call runcrud
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo RUN_CRUD has errors - breaking work
goto fail

: runbrowser
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo There is a problem, can't start the browser.
goto fail

: fail
echo.
echo There were errors...

: end
echo.
echo Everything was done.

