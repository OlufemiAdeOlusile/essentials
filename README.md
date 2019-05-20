# Project Title - essentials
Web and Web-Mobile testing for trading platform
via Selenium, Cucumber and Java

## Getting Started
git clone https://github.com/OlufemiAdeOlusile/essentials.git

### Prerequisites
Docker and GIT

### Installing
* Clone the repo
* Navigate to the project directory for the cloned repo (e.g, /download/essentials).
* Edit configuration in docker-compose.yml
    > * Default port for chrome in compose is **4444:4444**, you can change if port is 
    already in use (e.g `<port4Chrome>`:4444)
    > * Default port for vnc viewer in compose is **5900:5900**, you can change if port is 
    already in use (e.g `<port4VNC>`:5900)
    > * Include remote uri in *-Dbrowser.remote_uri*. Get host machine IP address. For example using 
    *ifconfig* on your terminal and search for IPv4 address or inet addr. 
   **http://`<HostIPADD>`:`<port4Chrome>`/wd/hub** (e.g, **'http://194.133.4.53:4444/wd/hub'**)
    > * Include website url in *-Dtest.url*
    > * For mobile run change *-Dbrowser.type* to **'CHROME_MOBILE'** and for a standard web browser change to **'CHROME'**

````yaml
chrome:
    image: selenium/standalone-chrome-debug:3.141.59-neon
    ports:
      - "5900:5900"
      - "4444:4444"
maven:
    image: maven:3.6.1-jdk-12
    stop_signal: SIGKILL
    stdin_open: true
    tty: true
    working_dir: $PWD
    volumes:
      - $PWD:$PWD
      - /var/run/docker.sock:/var/run/docker.sock
      - ~/.m2:/root/.m2
    command: bash -c "mvn clean install &&
             mvn verify -pl functionaltest
             -Dbrowser.remote_uri='http://<HostIPADD>:4444/wd/hub'
             -Dtest.url='<website_url>'
             -Dbrowser.type='CHROME_MOBILE'
             -Dskip.tests=‘false’" 
````

### Running the tests
* To run in foreground,  
> ***$ docker-compose up*** 

* View test run by using the VNC server. In your browser type in vnc://localhost:5900 or vnc://`<HostIPADD>`:`<port4VNC>`
When you are prompted for the password it is **secret**

* Test report can be found in ***/essentials/target/cucumber-reports/cucumber-pretty/index.html***



### Authors
Olufemi Ade-Olusile


