function send {
[CmdletBinding()]
param (
    [parameter(Position=0,Mandatory=$True)]
    [string]$hookUrl,
    [parameter(Position=1,Mandatory=$True)]
    [string]$content
)

$payload = [PSCustomObject]@{

    content = $content

}

Invoke-RestMethod -Uri $hookUrl -Method Post -Body ($payload | ConvertTo-Json) -ContentType 'Application/Json'
}
