user=<username>
key=<APIKEY>
base_url="https://$user:$key@api.bintray.com/"

version=1.3.3
# Generate files
# ./gradlew createPom javadocJar sourcesJar -PpomVersion=$version

# # Create new version only if you have a new version
curl \
    -X POST \
    $base_url/packages/tus/maven/tus-android-client/versions \
    -H "Content-Type: application/json" \
    -d "{\"name\":\"${version}\",\"vcs_tag\":\"${version}\"}"

function upload {
    local src=$1
    local dst=$2

    curl \
        -X PUT \
        "$base_url/content/jasonlamkk/AndroidColorfulParticleSystem/colorfulparticlesystem/$version/com/github/jasonlamkk/colorfulparticlesystem/$version/$dst?publish=1" \
        -T $src
}

# Upload files
upload "colorfulparticlesystem/build/outputs/aar/colorfulparticlesystem-release.aar" "colorfulparticlesystem-$version.aar"
upload "colorfulparticlesystem/build/poms/pom-default.xml" "colorfulparticlesystem-$version.pom"