check-env:
	make --version
	git --version
test:
	mvn clean test
