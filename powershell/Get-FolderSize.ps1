<#
.SYNOPSIS
    指定フォルダ直下の各項目（ファイル・サブフォルダ）のサイズを大きい順に表示する。

.PARAMETER Path
    調べたいフォルダのパス。省略時はカレントディレクトリ。

.EXAMPLE
    ./Get-FolderSize.ps1 -Path C:\Users\doral\Downloads
#>
[CmdletBinding()]
param(
    [string]$Path = "."
)

if (-not (Test-Path -LiteralPath $Path)) {
    Write-Error "パスが見つかりません: $Path"
    exit 1
}

Get-ChildItem -LiteralPath $Path -Force |
    ForEach-Object {
        $bytes = if ($_.PSIsContainer) {
            (Get-ChildItem -LiteralPath $_.FullName -Recurse -Force -ErrorAction SilentlyContinue |
                Measure-Object -Property Length -Sum).Sum
        } else {
            $_.Length
        }
        [PSCustomObject]@{
            Name   = $_.Name
            Type   = if ($_.PSIsContainer) { "Dir" } else { "File" }
            SizeMB = [math]::Round(($bytes / 1MB), 2)
        }
    } |
    Sort-Object SizeMB -Descending |
    Format-Table -AutoSize
